package com.zrz.crm.service;

import com.zrz.crm.enums.AttrStatusEnum;
import com.zrz.crm.enums.DeleteFlagEnum;
import com.zrz.crm.mapper.AttrTypeMapper;
import com.zrz.crm.mapper.AttrValueMapper;
import com.zrz.crm.model.AttrType;
import com.zrz.crm.model.AttrValue;
import com.zrz.crm.utils.AssertUtil;
import com.zrz.crm.web.config.advice.ExceptionEnum;
import com.zrz.crm.web.dto.ValueNameDto;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttrService {

    @Resource
    private AttrTypeMapper attrTypeMapper;

    @Resource
    private AttrValueMapper attrValueMapper;


    public List<ValueNameDto> getAttrValue(String attrType) {
        AssertUtil.notNull(attrType, ExceptionEnum.NotNullCode);
        List<ValueNameDto> valueNameDtoList = new ArrayList<>(10);

        Example example = new Example(AttrType.class);
        example.createCriteria().andEqualTo("code", attrType).andEqualTo("status", AttrStatusEnum.VALID_VALUE);
        List<AttrType> attrTypeList = attrTypeMapper.selectByExample(example);
        if (null != attrTypeList && attrTypeList.size() > 0) {
            AttrType attrType1 = attrTypeList.get(0);
            Integer attrTypeId = attrType1.getId();

            example = new Example(AttrValue.class);
            example.createCriteria().andEqualTo("attrTypeId", attrTypeId)
                    .andEqualTo("status", AttrStatusEnum.VALID_VALUE)
                    .andEqualTo("deleteFlag", DeleteFlagEnum.NOT_DELETED.getCode());
            List<AttrValue> attrValueList = attrValueMapper.selectByExample(example);

            ValueNameDto valueNameDto;
            for (AttrValue attrValue : attrValueList) {
                valueNameDto = new ValueNameDto();
                valueNameDto.setId(attrValue.getId());
                valueNameDto.setCode(attrValue.getCode());
                valueNameDto.setName(attrValue.getName());
                valueNameDtoList.add(valueNameDto);
            }
        }
        return valueNameDtoList;
    }
}
