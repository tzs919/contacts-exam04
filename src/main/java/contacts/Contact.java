package contacts;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Contact {
    private Long id;

    @NotNull
    @Size(min = 1, message = "名字必须至少1个字符")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "名字必须至少1个字符")
    private String lastName;

    @Pattern(regexp = "^1([34578])\\d{9}$", message = "无效的手机号码")
    private String phoneNumber;

    @NotBlank(message="不能为空")
    @Email
    private String emailAddress;

}