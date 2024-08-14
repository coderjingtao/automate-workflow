package com.joseph.workflow.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Joseph.Liu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {

    private int code;

    private String status;

    private String msg;

    private Boolean success;
}
