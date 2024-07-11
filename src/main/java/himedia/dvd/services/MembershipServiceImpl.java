package himedia.dvd.services;

import java.util.List;

import org.apache.catalina.tribes.membership.Membership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.dvd.repositories.dao.MembershipDao;
import himedia.dvd.repositories.vo.MembershipVo;

@Service("membershipService")
public class MembershipServiceImpl implements MembershipService {

	@Autowired
	private MembershipDao membershipDao;
	
	@Override
	public List<MembershipVo> getAllmembers() {
		List<MembershipVo> list = membershipDao.getAllMemberships();
		return list;
	}

	@Override
	public Membership getMembershipById(int id) {
		return membershipDao.modifymembership(id);
	}

	@Override
	public boolean membershipmodify(MembershipVo membershipVo) {
		int membershipmodifyCount = membershipDao.modify(membershipVo);
		return membershipmodifyCount == 1;
	}


}
