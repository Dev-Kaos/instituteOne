package com.institute.one;

import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.institute.one.user.persistence.model.PermissionEntity;
import com.institute.one.user.persistence.model.RoleEntity;
import com.institute.one.user.persistence.model.RoleEnum;
import com.institute.one.user.persistence.model.UserEntity;
import com.institute.one.user.persistence.repository.IUserRepository;

@SpringBootApplication
public class OneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}

	@Bean
	CommandLineRunner init(IUserRepository userRepository) {

		return args -> {

			// System.out.println("Hello World");

			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(readPermission, updatePermission))
					.build();

			RoleEntity roleGuest = RoleEntity.builder()
					.roleEnum(RoleEnum.GUEST)
					.permissionList(Set.of(readPermission))
					.build();

			UserEntity userManuel = UserEntity.builder()
					.username("manuel")
					.password("1234")
					.isEnabled(true)
					.isAccountNoExpired(true)
					.isAccountNoLocked(true)
					.isCredentialsNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();
			UserEntity userFernando = UserEntity.builder()
					.username("fernando")
					.password("1234")
					.isEnabled(true)
					.isAccountNoExpired(true)
					.isAccountNoLocked(true)
					.isCredentialsNoExpired(true)
					.roles(Set.of(roleUser))
					.build();
			UserEntity userGeraldine = UserEntity.builder()
					.username("geraldine")
					.password("1234")
					.isEnabled(true)
					.isAccountNoExpired(true)
					.isAccountNoLocked(true)
					.isCredentialsNoExpired(true)
					.roles(Set.of(roleGuest))
					.build();

			userRepository.saveAll(Set.of(userManuel, userFernando, userGeraldine));
		};
	}

}
