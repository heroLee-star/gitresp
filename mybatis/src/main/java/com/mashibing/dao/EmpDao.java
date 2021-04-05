package com.mashibing.dao;

import com.mashibing.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {
    public Integer save (Emp emp);
    public Integer update (Emp emp);
    public Integer delete (Integer empno);
    public Emp selectEmpByEmpno (Integer empno);
    public List selectAll();

    public List selectAllByParam(@Param("empno") Integer empno, @Param("sal") Double sal);

    public List selectAllByMap(Map<Integer,Double> map);

    public List selectMyEmp(Emp emp);

}
