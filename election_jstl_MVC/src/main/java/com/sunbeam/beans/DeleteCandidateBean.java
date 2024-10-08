package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class DeleteCandidateBean {
	private int id;
	private String name;
	private String party;
	private int votes;
	private int count;
	
public DeleteCandidateBean() {
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
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

@Override
public String toString() {
	return "DeleteCandidateBean [id=" + id + ", name=" + name + ", party=" + party + ", votes=" + votes + ", count="
			+ count + "]";
}
public void DeleteCandidate() {
	Candidate c = new Candidate(id, name, party, votes);
	try(CandidateDao candDao = new CandidateDaoImpl()) {
		count = candDao.deleteById(id);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
