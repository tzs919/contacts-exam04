package contacts;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
public class Contact {
    @Id
    private String id;

    @NotNull
    @Size(min = 1, message = "名字必须至少1个字符")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "名字必须至少1个字符")
    private String lastName;

    @Pattern(regexp = "^1([34578])\\d{9}$", message = "无效的手机号码")
    private String phoneNumber;

    @NotBlank(message = "不能为空")
    @Email
    private String emailAddress;

}