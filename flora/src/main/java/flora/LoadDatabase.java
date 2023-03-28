package flora;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(FloraRepository repository) {
		return args -> {log.info("Skiped");} ;
		// return args -> {
        //     try (FileReader fr = new FileReader("/home/ilya/florabolot/data.csv");
        //          BufferedReader br = new BufferedReader(fr);
        //          ) {
        //         String line ="";

        //         while (line!=null) {
        //             line = br.readLine();
        //             if (line!=null){
        //                 String[] values=line.split(";");
		// 				//log.info("Preloading " + repository.save(new Flora("Athyrium filix-femina (L.) Roth", "Кочедыжник женский "," "," "," "," ","1"," "," "," ")));
		// 				log.info("Preloading " + repository.save(new Flora(values[0],
		// 				 values[1],
		// 				 values[2],
		// 				 values[3],
		// 				 values[4],
		// 				 values[5],
		// 				 values[6],
		// 				 values[7],
		// 				 values[8],
		// 				 values[9])));
		// 			}
		// 		}
		// 	}
		// };
	}    
}
