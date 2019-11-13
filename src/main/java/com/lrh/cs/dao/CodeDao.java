package com.lrh.cs.dao;

import com.lrh.cs.pojo.Code;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeDao {
    List<Code> queryList();
    List<Code> code2(@Param("dirid")Integer dirid);
    List<Code> code3(@Param("dirid")Integer dirid);
}
