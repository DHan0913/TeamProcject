package himedia.dvd.services;

import java.util.List;

import org.apache.catalina.tribes.membership.Membership;

import himedia.dvd.repositories.vo.MembershipVo;

public interface MembershipService {

	List<MembershipVo> getAllmembers();
	Membership getMembershipById(int id);
	boolean membershipmodify(MembershipVo membershipVo);


}
