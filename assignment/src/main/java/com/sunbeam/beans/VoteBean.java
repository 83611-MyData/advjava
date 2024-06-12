package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
//import com.sunbeam.pojos.Candidate;

public class VoteBean {
	private int candidateId;
	private String name;
	private String party;
	
	
	private int votes;
	private int count;
	
	
	private int userId;
	private int status;
	
	public VoteBean() {
		// TODO Auto-generated constructor stub
	}


	


	public int getCandidateId() {
		return candidateId;
	}





	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	




	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getParty() {
		return party;
	}





	public void setParty(String party) {
		this.party = party;
	}





	public int getVotes() {
		return votes;
	}


	public void setVotes(int votes) {
		this.votes = votes;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
	
	 public int getUserId() {
		return userId;
	}





	public void setUserId(int userId) {
		this.userId = userId;
	}





	public int getStatus() {
		return status;
	}





	public void setStatus(int status) {
		this.status = status;
	}





	public void registerVote() {
	        try (CandidateDao candDao = new CandidateDaoImpl()) {
	            count = candDao.incrementVote(candidateId);
	            System.out.println(count);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	 public void incrementStatus() {
		try(UserDao userdao = new UserDaoImpl()){
			status = userdao.updateStatus(userId, true);
		}catch (Exception e) {
            e.printStackTrace();
        }
	 }

}
