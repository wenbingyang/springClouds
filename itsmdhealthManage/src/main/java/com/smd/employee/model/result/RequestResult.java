package com.smd.employee.model.result;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @Description: 请求通用返回结果
 * @Author: 010508
 * @CreateDate: 2018/3/2 10:04
 * @UpdateUser: 010508
 * @UpdateDate: 2018/3/2 10:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class RequestResult {
    private boolean error;

    private String errorDesc;

    private int code;

    @NonNull
    private Object result;

}
