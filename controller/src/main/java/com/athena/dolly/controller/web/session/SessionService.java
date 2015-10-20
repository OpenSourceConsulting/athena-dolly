package com.athena.dolly.controller.web.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.dolly.controller.ServiceResult;
import com.athena.dolly.controller.ServiceResult.Status;

@Service
public class SessionService {
	@Autowired
	private SessionRepository sessionRepo;

	public ServiceResult add(String key, String value) {
		Session session = sessionRepo.save(new Session(key, value));
		return new ServiceResult(Status.DONE, "Done", session);
	}

	public ServiceResult edit(int Id, String key, String value) {
		Session s = sessionRepo.findOne(Id);
		if (s == null) {
			return new ServiceResult(Status.FAILED, "Not exist");
		}
		if (!key.equals("") && !value.equals("")) {
			s.setKey(key);
			s.setValue(value);
			sessionRepo.save(s);
			return new ServiceResult(Status.DONE, "Done", s);
		}
		return new ServiceResult(Status.FAILED, "Wrong key or value");
	}

	public ServiceResult delete(int Id) {
		Session s = sessionRepo.findOne(Id);
		if (s == null) {
			return new ServiceResult(Status.FAILED, "Not exist");
		}
		sessionRepo.delete(Id);
		return new ServiceResult(Status.DONE, "Done");
	}
}
