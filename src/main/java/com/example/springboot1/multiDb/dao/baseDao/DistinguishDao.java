//package com.example.springboot1.multiDb.dao.baseDao;
//
//import com.intellif.smart.dto.CameraInfo;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @author liang.xiongwei
// * @Title: DistinguishDao
// * @Package com.intellif.smart.dao
// * @Description
// * @date 2018/11/30 10:27
// */
//@Repository
//public interface DistinguishDao {
//    /**
//     * 初始化设备配置
//     * @param cameraInfoList
//     * @return Integer
//     */
//    int addCameraInfos(@Param("list") List<CameraInfo> cameraInfoList);
//
//    /**
//     * 初始化引擎调用表
//     * @param cameraIdList
//     * @return
//     */
//    int addTaskInfos(@Param("list") List<Long> cameraIdList);
//
//    /**
//     * 初始化人员表
//     * @param list
//     * @return
//     */
//    int addPersons(@Param("list") List<Object> list);
//
//    /**
//     * 查询设备id
//     * @return
//     */
//    List<Long> selectCameraIds();
//
//    /**
//     * 更新特征值
//     * @param feature
//     * @param personCode
//     * @return
//     */
//    int updatePersonFeature(@Param("feature") byte[] feature, @Param("personCode") String personCode);
//
//    /**
//     * 新增人员信息
//     * @param data
//     * @return
//     */
//    int insertPersonInfo(Map<String, Object> data);
//
//    /**
//     * 修改人员信息
//     * @param data
//     * @return
//     */
//    int updatePersonInfo(Map<String, Object> data);
//
//    /**
//     * 删除人员
//     * @param data
//     * @return
//     */
//    int deletePersonInfo(String data);
//}
