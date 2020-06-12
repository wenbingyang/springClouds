package com.sclouds.subscrib.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /** 编号 */
    private String userId;
    /** 姓名 */
    private String userName;
    private String password;

}
