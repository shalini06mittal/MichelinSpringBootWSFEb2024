package com.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDatabase {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public Long getBookCount()
    {
        String sql = "select count(*) from book";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
    public void insertBook(Book book) {
// Line 1
        String sql = "insert into book values(?,?,?)";
// Line 2
        int count = jdbcTemplate.update(sql,
                book.getId(),book.getName(),book.getPrice());
// Line 3
        System.out.println("=====>>> count :: " + count);
    }
    public void updateBook(Integer id, String name) {
// Line 1
        String sql = "update book set name=? where id = ? ";
// Line 2
        int count = jdbcTemplate.update(sql, name, id);
// Line 3
        System.out.println("=====>>> count :: " + count);
    }
    public void deleteBook(Integer id) {
// Line 1
        String sql = "delete from book where id = ? ";
// Line 2
        int count = jdbcTemplate.update(sql,id);
// Line 3
        System.out.println("=====>>> count :: " + count);
    }
    public void queryForBookName(Integer id) {
        String sql = "SELECT name FROM Book where id = ?";
        String name = jdbcTemplate.queryForObject(sql,
                new Object[]{id} ,String.class);
        System.out.println("=====>>> Name :: " + name);
    }
    public void queryForBook(Integer id) {
        String sql = "SELECT * FROM book where id = ?";
        Book Book = jdbcTemplate.queryForObject(sql,
                new Object[] {id}, new BookMapper());
        System.out.println("=====>>> Book details :: " + Book);
    }
    public void queryForBooks() {
        String sql = "SELECT * FROM book";
        List<Book> Book = jdbcTemplate.query(sql, new BookMapper());
        System.out.println("ID\tName\tPrice");
        for (Book book : Book)
        {
            System.out.print(book.getId()+"\t");
            System.out.print(book.getName()+"\t");
            System.out.print(book.getPrice()+"\t");
            System.out.println();
        }
    }
    class BookMapper implements RowMapper<Book> {
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book c1 = new Book();
            c1.setId(rs.getInt(1));
            c1.setName(rs.getString(2));
            c1.setPrice(rs.getDouble(3));
            return c1;
        }
    }
}
