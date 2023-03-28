package flora;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
class Flora {

	private @Id @GeneratedValue Long id;
	@NonNull 
	private String lat;

	@NonNull 
	private String rus;

	@NonNull 
	private String status;

	@NonNull 
	private String poduvalnoe;

	@NonNull 
	private String vishenskoe;

	@NonNull 
	private String maslovo;

	@NonNull 
	private String chernoe;

	@NonNull 
	private String verhovie;

	@NonNull 
	private String perehodnie;

	@NonNull 
	private String travyanie;
}