package api.controllers;

import api.domain.User;
import com.google.gson.Gson;
import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

  private static final Gson gson = new Gson();

  @PostMapping(
    value = "/users",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = { "multipart/form-data" }
  )
  public @ResponseBody ResponseEntity<String> test(int id, String name)
    throws IOException {
    User user = new User(id, name);

    return ResponseEntity.status(200).body(gson.toJson(user));
  }
}
