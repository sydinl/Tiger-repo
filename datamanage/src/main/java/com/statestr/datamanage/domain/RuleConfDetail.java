package com.statestr.datamanage.domain;

import lombok.Data;

@Data
public class RuleConfDetail {

    String ruleId;

    String ruleDetailsId;

    String sourceColumn;

    String dataRule;

    String validationRule;

    String destinationColumn;

}
