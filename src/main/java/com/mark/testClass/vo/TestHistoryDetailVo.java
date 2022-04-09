package com.mark.testClass.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName:TestHistoryDetailVo
 * Package:com.mark.springbootmarkopensource.testClass.vo
 * Description:
 *
 * @Date:2021/10/20 10:13
 * @Author: mark
 */
public class TestHistoryDetailVo {
    public static void main(String[] args) {
        List<PatientPrescriptionHistoryDetailsVo> listVo = new ArrayList<>();
        PatientPrescriptionHistoryDetailsVo vo1 = PatientPrescriptionHistoryDetailsVo
                .builder()
                .patientId("123")
                .clinicalDiagnosis("高血压,冠心病")
                .dosage(5).drugsName("感康西明1")
                .entrust("不要饮酒")
                .inquiryDate("2021年10月20")
                .medicationDays(3)
                .singleDose("每天三次")
                .patientName("张三")
                .medicationRoute("口服")
                .medicationFrequency("一次 20 mg")
                .build();
        PatientPrescriptionHistoryDetailsVo vo2 = PatientPrescriptionHistoryDetailsVo
                .builder()
                .patientId("123")
                .clinicalDiagnosis("高血压,冠心病")
                .dosage(5).drugsName("感康西明2")
                .entrust("不要饮酒")
                .inquiryDate("2021年9月20")
                .medicationDays(3)
                .singleDose("每天三次")
                .patientName("张三")
                .medicationRoute("口服")
                .medicationFrequency("一次 20 mg")
                .build();
        listVo.add(vo2);
        listVo.add(vo1);

        if (listVo.size() > 0) {
            listVo.stream().peek(c ->
                    c.setUseDetail(c.getMedicationRoute() + "," + c.getSingleDose() + "," + c.getMedicationFrequency())
            ).collect(Collectors.toList());

        }else{
            listVo = new ArrayList<>();
        }

      listVo.stream().forEach(c->
              System.out.println(c)
              );
    }
}
