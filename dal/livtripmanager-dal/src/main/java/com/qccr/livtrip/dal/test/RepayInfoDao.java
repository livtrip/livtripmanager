package com.qccr.livtrip.dal.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.qccr.livtrip.model.test.RepayInfo;

@Mapper
public interface RepayInfoDao {
    int insert(@Param("pojo") RepayInfo pojo);

    int insertSelective(@Param("pojo") RepayInfo pojo);

    int insertList(@Param("pojos") List<RepayInfo> pojo);

    int update(@Param("pojo") RepayInfo pojo);

    List<RepayInfo> queryForList();

    RepayInfo getById(@Param("id") Integer id);
}
