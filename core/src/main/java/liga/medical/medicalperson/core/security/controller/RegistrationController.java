package liga.medical.medicalperson.core.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.medicalperson.core.security.entity.User;
import liga.medical.medicalperson.core.security.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Api(value = "API отвечающий за регистрацию и валидацию новых пользователей")
public class RegistrationController {

    private final UserService userService;

    private final UserValidator userValidator;

    @PostMapping("/registration")
    @ApiOperation(value = "Валидация и добавление в базу данных нового пользователя")
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        return "redirect:/";
    }

    @GetMapping("/registration")
    @ApiOperation(value = "Создание нового пользователя")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }
}
