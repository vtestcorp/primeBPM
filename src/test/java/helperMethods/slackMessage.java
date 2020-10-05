package helperMethods;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Builder(builderClassName = "Builder")
@Getter
@Setter
/**
 * @author Bobby
 */
public class slackMessage implements Serializable {

	private String username;
	private String text;
	private String icon_emoji;
	private String file;
}
