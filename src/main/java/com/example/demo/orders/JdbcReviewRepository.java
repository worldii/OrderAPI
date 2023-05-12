package com.example.demo.orders;

import com.example.demo.utils.DateTimeUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcReviewRepository implements ReviewRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Review save(Review review) {
        String mysql = "insert into reviews (userSeq, productSeq, content, createAt) values (?, ?, ?, ?)";
        jdbcTemplate.update(mysql, review.getUserSeq(), review.getProductSeq(), review.getContent(), review.getCreateAt());
        return review ;
    }

    @Override
    public Optional<Review> findById(long id) {
        List<Review> query = jdbcTemplate.query("select * from reviews where seq=?", mapper, id);
        return Optional.ofNullable(query.isEmpty() ? null : query.get(0));
    }

    RowMapper<Review> mapper = (rs, rowNum) ->
            new Review.Builder()
                    .seq(rs.getLong("seq"))
                    .userSeq(rs.getLong("userSeq"))
                    .productSeq(rs.getLong("productSeq"))
                    .content(rs.getString("content"))
                    .createAt(DateTimeUtils.dateTimeOf(rs.getTimestamp("createAt")))
                    .build();
}
