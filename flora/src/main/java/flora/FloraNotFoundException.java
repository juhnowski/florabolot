package flora;

class FloraNotFoundException extends RuntimeException {

    FloraNotFoundException(Long id) {
		super("Could not find flora " + id);
	}

}
