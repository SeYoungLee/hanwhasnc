package examples.guestbook.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GuestbookForm {
	@NotNull
	@Size(min=2, max=30)
	private String name;
	@NotNull
	@Size(min=1, max=4000)
	private String content;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
