package com.mmcoe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mmcoe.pojo.Book;


import jdbc.pro.JdbcFactory;

public class BookDaoJdbcImpl implements BookDao {

    @Override
    public boolean save(Book b) {

        String sql = "insert into books values (?, ?, ?, ?)";

        Connection conn;
		try {
			conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

	        stmt.setInt(1, b.getIsbn());
	        stmt.setString(2, b.getTitle());
	        stmt.setString(3, b.getAuthor());
	        stmt.setDouble(4, b.getPrice());

	        stmt.executeUpdate();

	        return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}

        
    }

    @Override
    public Optional<Book> find(int isbn) {

        String sql = "select * from books where isbn=?";

        try {

            Connection conn = JdbcFactory.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(1, isbn);

            ResultSet rs = stmt.executeQuery();

            Book b = null;

            if(rs.next()) {

                b = new Book();

                b.setIsbn(rs.getInt(1));
                b.setTitle(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
            }

            return Optional.ofNullable(b);

        } catch(SQLException e) {

            e.printStackTrace();
            return Optional.empty();
        }
    }
    
    @Override
    public List<Book> list() {

        List<Book> books =
                new ArrayList<>();

        String sql =
                "select * from books";

        try {

            Connection conn =
                    JdbcFactory.getConnection();

            ResultSet rs =
                    conn.createStatement()
                        .executeQuery(sql);

            while(rs.next()) {

                Book b = new Book();

                b.setIsbn(rs.getInt(1));
                b.setTitle(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));

                books.add(b);
            }

        } catch(SQLException e) {

            e.printStackTrace();
        }

        return books;
    }
    @Override
    public boolean delete(int isbn) {

        String sql =
                "delete from books where isbn=?";

        try {

            Connection conn =
                    JdbcFactory.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(1, isbn);

            int rows =
                    stmt.executeUpdate();

            return rows > 0;

        } catch(SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Book b) {

        String sql =
                "update books set title=?, author=?, price=? where isbn=?";

        try {

            Connection conn =JdbcFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, b.getTitle());
            stmt.setString(2, b.getAuthor());
            stmt.setDouble(3, b.getPrice());
            stmt.setInt(4, b.getIsbn());

            return stmt.executeUpdate() > 0;

        } catch(SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Book> findByPrice(double min, double max) {

        List<Book> books = new ArrayList<>();

        String sql =
                "select * from books where price between ? and ?";

        try {

            Connection conn =
                    JdbcFactory.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setDouble(1, min);
            stmt.setDouble(2, max);

            ResultSet rs =
                    stmt.executeQuery();

            while(rs.next()) {

                Book b = new Book();

                b.setIsbn(rs.getInt(1));
                b.setTitle(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));

                books.add(b);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return books;
    }
}
