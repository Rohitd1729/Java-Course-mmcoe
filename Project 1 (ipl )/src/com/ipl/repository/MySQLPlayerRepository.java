package com.ipl.repository;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipl.util.DBUtil;
import com.ipl.model.Player;

public class MySQLPlayerRepository
        implements PlayerRepository {

	@Override
	public List<Player> findAll() {

	    List<Player> players =
	            new ArrayList<>();

	    String sql =
	            "select * from player";

	    try (
	        Connection con =
	                DBUtil.getConnection();

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ResultSet rs =
	                ps.executeQuery()
	    ) {

	        while(rs.next()) {

	            Player p =
	                    new Player(
	                            rs.getInt("player_id"),
	                            rs.getString("player_name"),
	                            rs.getString("team_name"),
	                            rs.getString("role"),
	                            rs.getDouble("bid_amount"));

	            players.add(p);
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return players;
	}

	@Override
	public void save(Player player) {

	    String sql =
	            "insert into player values(?,?,?,?,?)";

	    try (
	        Connection con =
	                DBUtil.getConnection();

	        PreparedStatement ps =
	                con.prepareStatement(sql)
	    ) {

	        ps.setInt(
	                1,
	                player.getPlayerId());

	        ps.setString(
	                2,
	                player.getPlayerName());

	        ps.setString(
	                3,
	                player.getTeamName());

	        ps.setString(
	                4,
	                player.getRole());

	        ps.setDouble(
	                5,
	                player.getBidAmount());

	        ps.executeUpdate();

	        System.out.println(
	                "Player Saved Successfully");

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}

	@Override
	public void update(Player player) {

	    String sql =
	            "update player "
	            + "set team_name=?, "
	            + "role=?, "
	            + "bid_amount=? "
	            + "where player_id=?";

	    try (
	        Connection con =
	                DBUtil.getConnection();

	        PreparedStatement ps =
	                con.prepareStatement(sql)
	    ) {

	        ps.setString(
	                1,
	                player.getTeamName());

	        ps.setString(
	                2,
	                player.getRole());

	        ps.setDouble(
	                3,
	                player.getBidAmount());

	        ps.setInt(
	                4,
	                player.getPlayerId());

	        int rows =
	                ps.executeUpdate();

	        System.out.println(
	                rows + " row updated");

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}

	@Override
	public void delete(int playerId) {

	    String sql =
	            "delete from player "
	            + "where player_id=?";

	    try (
	        Connection con =
	                DBUtil.getConnection();

	        PreparedStatement ps =
	                con.prepareStatement(sql)
	    ) {

	        ps.setInt(
	                1,
	                playerId);

	        int rows =
	                ps.executeUpdate();

	        System.out.println(
	                rows + " row deleted");

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}
}