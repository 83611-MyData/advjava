package com.sunbeam.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojos.Candidate;

public class CandidateDaoImpl extends Dao implements CandidateDao {
	public CandidateDaoImpl() throws Exception {
	}
	public int deleteById(int id) throws Exception {
		String sql = "DELETE FROM candidates WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int cnt = stmt.executeUpdate();
			return cnt;
		}
	}
	public List<Candidate> findAll() throws Exception {
		List<Candidate> list = new ArrayList<>();
		String sql = "SELECT * FROM candidates";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String party = rs.getString("party");
					int votes = rs.getInt("votes");
					Candidate c = new Candidate(id, name, party, votes);
					list.add(c);
				}
			}
		} 
		return list;
	}
	public int incrementVote(int candidateId) throws Exception {
		String sql = "UPDATE candidates SET votes=votes+1 WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, candidateId);
			int cnt = stmt.executeUpdate();
			return cnt; 
		} 
	}
	
	public Candidate findById(int id) throws Exception {
 		String sql = "SELECT * FROM candidates WHERE id=?";
 		try(PreparedStatement stmt = con.prepareStatement(sql)) {
 			stmt.setInt(1, id);
 			try(ResultSet rs = stmt.executeQuery()) {
 				if(rs.next()) {
 					id = rs.getInt("id");
 					String name = rs.getString("name");
 					String party = rs.getString("party");
 					int votes = rs.getInt("votes");
 					Candidate c = new Candidate(id, name, party, votes);
 					return c;
 				}
 			} 
 		} 
 		return null;
	}
	
	public List<Candidate> findByParty(String givenParty) throws Exception {
		List<Candidate> list = new ArrayList<>();
		String sql = "SELECT * FROM candidates WHERE party=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, givenParty);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String party = rs.getString("party");
					int votes = rs.getInt("votes");
					Candidate c = new Candidate(id, name, party, votes);
					list.add(c);
				}
			}
		}
		return list;
	}
	public int save(Candidate c) throws Exception {
		String sql = "INSERT INTO candidates VALUES(default, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getParty());
			stmt.setInt(3, c.getVotes());
			return stmt.executeUpdate();
		} 
	}
	public int update(Candidate c) throws Exception {
		String sql = "UPDATE candidates SET name=?, party=?, votes=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getParty());
			stmt.setInt(3, c.getVotes());
			stmt.setInt(4, c.getId());
			return stmt.executeUpdate();
		} 
	}
	public List<Candidate> getCandidatewiseVotes() throws Exception {
		List<Candidate> list = new ArrayList<>();
		String sql = "SELECT * FROM candidates ORDER BY votes DESC";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String party = rs.getString("party");
					int votes = rs.getInt("votes");
					Candidate c = new Candidate(id, name, party, votes);
					list.add(c);
				}
			} 
		} 
		return list;
	}
}