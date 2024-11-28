package com.portfolio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PortfolioDBUtil {

    public static boolean insertPortfolio(String category, String name, String venue, String date, String introduction,
            String image1, String image2, String image3) {
        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DBconnect.getConnection();
            String sql = "INSERT INTO portfolio (category, name, venue, date, introduction, image1, image2, image3) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, category);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, venue);
            preparedStatement.setString(4, date);
            preparedStatement.setString(5, introduction);
            preparedStatement.setString(6, image1);
            preparedStatement.setString(7, image2);
            preparedStatement.setString(8, image3);

            int rowsAffected = preparedStatement.executeUpdate();
            isSuccess = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

    public static boolean updatePortfolio(Portfolio portfolio) {
        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DBconnect.getConnection();
            String sql = "UPDATE portfolio SET category=?, name=?, venue=?, date=?, introduction=?, image1=?, image2=?, image3=? WHERE id=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, portfolio.getCategory());
            preparedStatement.setString(2, portfolio.getName());
            preparedStatement.setString(3, portfolio.getVenue());
            preparedStatement.setString(4, portfolio.getDate());
            preparedStatement.setString(5, portfolio.getIntroduction());
            preparedStatement.setString(6, portfolio.getImage1());
            preparedStatement.setString(7, portfolio.getImage2());
            preparedStatement.setString(8, portfolio.getImage3());
            preparedStatement.setInt(9, portfolio.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            isSuccess = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

    public static boolean deletePortfolio(int id) {
        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DBconnect.getConnection();
            String sql = "DELETE FROM portfolio WHERE id=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            isSuccess = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

    public static List<Portfolio> getAllPortfolios() {
        List<Portfolio> portfolioList = new ArrayList<>();
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            con = DBconnect.getConnection();
            String sql = "SELECT * FROM portfolio";
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String category = resultSet.getString("category");
                String name = resultSet.getString("name");
                String venue = resultSet.getString("venue");
                String date = resultSet.getString("date");
                String introduction = resultSet.getString("introduction");
                String image1 = resultSet.getString("image1");
                String image2 = resultSet.getString("image2");
                String image3 = resultSet.getString("image3");

                Portfolio portfolio = new Portfolio(id, category, name, venue, date, introduction, image1, image2,
                        image3);

                portfolioList.add(portfolio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return portfolioList;
    }

    public static Portfolio getPortfolioById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Portfolio portfolio = null;

        try {
            conn = DBconnect.getConnection();
            String sql = "SELECT * FROM portfolio WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String category = rs.getString("category");
                String name = rs.getString("name");
                String venue = rs.getString("venue");
                String date = rs.getString("date");
                String introduction = rs.getString("introduction");
                String image1 = rs.getString("image1");
                String image2 = rs.getString("image2");
                String image3 = rs.getString("image3");

                portfolio = new Portfolio(id, category, name, venue, date, introduction, image1, image2, image3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return portfolio;
    }
}
