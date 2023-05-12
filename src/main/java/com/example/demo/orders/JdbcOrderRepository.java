package com.example.demo.orders;

import com.example.demo.utils.DateTimeUtils;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
public class JdbcOrderRepository implements OrderRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Orders findBySeq(Long seq) {

        List<Orders> results= jdbcTemplate.query("select * from orders where seq=?", mapper, seq);
        return ofNullable(results)
                .filter(o -> !o.isEmpty())
                .map(o -> o.get(0))
                .orElse(null);
    }

    @Override
    public List<Orders> findAll() {
        return jdbcTemplate.query("select * from orders", mapper);
    }

    @Override
    public OrderResponse findWithReviewById(Long id) {
        String sql = "select o.seq, o.review_seq, o.product_seq, o.state, o.request_msg, o.reject_msg, o.completed_at, o.rejected_at, o.create_at," +
                " r.content, r.create_at as r_create_at" +
                " from orders o left join reviews r on o.review_seq = r.seq" +
                " where o.seq =?";
        List<OrderResponse> results = jdbcTemplate.query(sql, mapper2, id);
        return ofNullable(results)
                .filter(o -> !o.isEmpty())
                .map(o -> o.get(0))
                .orElse(null);
    }

    @Override
    public boolean update(Orders order) {
        String sql = "update orders set state=?, request_msg=?, reject_msg=?, completed_at=?, rejected_at=? where seq=?";
        return jdbcTemplate.update(sql, order.getState().toString(), order.getRequestMsg(), order.getRejectMsg(), order.getCompletedAt(), order.getRejectedAt(), order.getSeq()) > 0;
    }




    static RowMapper<Orders> mapper = (rs, rowNum) ->
            new Orders.Builder()
                    .seq(rs.getLong("seq"))
                    .userSeq(rs.getLong("userSeq"))
                    .productSeq(rs.getLong("productSeq"))
                    .reviewSeq(rs.getLong("reviewSeq"))
                    .state(OrderState.valueOf(rs.getString("state")))
                    .requestMsg(rs.getString("requestMsg"))
                    .rejectMsg(rs.getString("rejectMsg"))
                    .completedAt(DateTimeUtils.dateTimeOf(rs.getTimestamp("completedAt")))
                    .rejectedAt(DateTimeUtils.dateTimeOf(rs.getTimestamp("rejectedAt")))
                    .createdAt(DateTimeUtils.dateTimeOf(rs.getTimestamp("createdAt"))).build();


    static RowMapper<OrderResponse> mapper2 = (rs, rowNum) -> {
        OrderResponse orderResponse = new OrderResponse.Builder()
                .seq(rs.getLong("seq"))
                .productId(rs.getLong("product_seq"))
                .state(OrderState.valueOf(rs.getString("state")))
                .requestMessage(rs.getString("request_msg"))
                .rejectMessage(rs.getString("reject_msg"))
                .completedAt(DateTimeUtils.dateTimeOf(rs.getTimestamp("completed_at")))
                .rejectedAt(DateTimeUtils.dateTimeOf(rs.getTimestamp("rejected_at")))
                .createdAt(DateTimeUtils.dateTimeOf(rs.getTimestamp("create_at")))
                .build();
        OrderResponse.ReviewDto reviewDto = new OrderResponse.ReviewDto(rs.getLong("review_seq"), rs.getLong("product_seq"), rs.getString("content"), DateTimeUtils.dateTimeOf(rs.getTimestamp("create_at")));
        orderResponse.setReviewDto(reviewDto);
        return orderResponse;
    };

}
