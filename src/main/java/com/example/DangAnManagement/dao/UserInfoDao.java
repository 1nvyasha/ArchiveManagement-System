package com.example.DangAnManagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.UserInfo;
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo>{
	//
	//创建修改deptid、roleid外键的触发器 
	//
	@Select("select * from userinfo")
	public List<UserInfo> getAllUserInfo();
	
	@Select("select * from userinfo where loginname='${loginname}'")
	public UserInfo getUserByName(String loginname);
	@Select("select loginpwd from userinfo where loginname='${loginname}'")
	public String getUserPwdByName(String loginSname);
	
	@Update("update userinfo set loginid='${userinfo.LoginId}', LoginName='${userinfo.LoginName}',LoginPwd='${userinfo.LoginPwd}',RoleId=${userinfo.RoleId},LevelId=${userinfo.LevelId},CardId='${userinfo.CardId}',DutyId=${userinfo.DutyId},DeptId=${userinfo.DeptId},JoinDate='${userinfo.JoinDate}',TelePhone='${userinfo.TelePhone}',EnduId=${userinfo.EnduId},Address='${userinfo.Address}',Sex='${userinfo.Sex}',Remark='${userinfo.Remark}' where loginname='${loginname}'")
	public void updateUserByName(UserInfo userinfo,String loginname);
	//参数存在 对象和其他参数时 如上处理 loginid='${userinfo.LoginId}' 否则Parameter 'LoginId' not found. Available parameters are [loginname, userinfo, param1, param2]
	
	@Delete("delete from userinfo where loginname='${loginname}'")
	public void deleteUserByName(String loginname);
	
	@Insert("insert into userinfo(LoginId,LoginName,LoginPwd,RoleId,LevelId,CardId,DutyId,DeptId,JoinDate,TelePhone,EnduId,Address,Sex,Remark)values('${LoginId}','${LoginName}','${LoginPwd}',${RoleId},${LevelId},'${CardId}',${DutyId},${DeptId},'${JoinDate}','${TelePhone}',${EnduId},'${Address}','${Sex}','${Remark}');")
	public void insertUserInfo(UserInfo userinfo);
	
	@Select("select * from userinfo where loginname like '%${loginname}%';")//'%${}%'可能会引发sql注入,建议使用#{}
	public List<UserInfo> searchUserByName(String loginname);
}
