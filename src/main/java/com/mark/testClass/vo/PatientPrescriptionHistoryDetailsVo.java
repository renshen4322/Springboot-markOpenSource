package com.mark.testClass.vo;

import lombok.Builder;
import lombok.Data;

/**
 * ClassName:PatientPrescriptionHistoryDetailsVo
 * Package:com.xinan.common.cloud.query.prescription
 * Description:
 *
 * @Date:2021/10/19 19:54
 * @Author: mark
 */
@Data
@Builder
public class PatientPrescriptionHistoryDetailsVo {
   // @ApiModelProperty(value = "患者id")
    private String patientId;
   // @ApiModelProperty(value = "患者姓名")
    private String patientName;
   // @ApiModelProperty(value = "临床诊断名称")
    private String clinicalDiagnosis;
   // @ApiModelProperty(value = "就诊日期")
    private String inquiryDate;
   // @ApiModelProperty(value = "药品名称")
    private String drugsName;
   // @ApiModelProperty(value = "发药量")
    private Integer dosage;
  //  @ApiModelProperty(value = "用药途径")
    private String medicationRoute;
  //  @ApiModelProperty(value = "用药频次")
    private String medicationFrequency;
  //  @ApiModelProperty(value = "单次剂量")
    private String singleDose;
   // @ApiModelProperty(value = "用法用量")
    private String useDetail;
    //@ApiModelProperty(value ="用药天数")
    private Integer medicationDays;
   // @ApiModelProperty(value = "嘱托")
    private String entrust;
}
