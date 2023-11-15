package umc.study.service.UserService;

import umc.study.domain.User;
import umc.study.web.dto.UserRequestDTO;

public interface UserCommandService {
    public User joinUser(UserRequestDTO.JoinDto request);
}
