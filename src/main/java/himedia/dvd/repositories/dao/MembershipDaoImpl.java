package himedia.dvd.repositories.dao;

import java.util.List;

import org.apache.catalina.tribes.membership.Membership;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.dvd.repositories.vo.MembershipVo;

@Repository("membershipDao")
public class MembershipDaoImpl implements MembershipDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MembershipVo> getAllMemberships() {
		List<MembershipVo> list = sqlSession.selectList("membership.getAllMemberships");
		return list;
	}

	@Override
	public int modify(MembershipVo membershipVo) {
		return sqlSession.update("membership.updateMembership", membershipVo);
	}

	@Override
	public Membership modifymembership(int id) {
		return sqlSession.selectOne("membership.updateMembership", id );
	}


}
