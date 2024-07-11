package himedia.dvd.repositories.dao;

import java.util.List;

import org.apache.catalina.tribes.membership.Membership;

import himedia.dvd.repositories.vo.MembershipVo;

public interface MembershipDao {

	List<MembershipVo> getAllMemberships();
	Membership modifymembership(int id);
	int modify(MembershipVo membershipVo);

}
