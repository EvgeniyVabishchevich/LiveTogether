package by.natariyz.livetogether.controller;

import by.natariyz.livetogether.dto.RoomDto;
import by.natariyz.livetogether.exception.RoomNotFoundException;
import by.natariyz.livetogether.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static by.natariyz.livetogether.utils.Constants.Attributes.ROOM_URL;
import static by.natariyz.livetogether.utils.Constants.HtmlFiles.ROOM;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/create")
    public ModelAndView createRoomAndRedirect(RedirectAttributes redirectAttributes) {
        RoomDto room = roomService.createRoom();

        redirectAttributes.addAttribute("roomUrl", room.getUrl());

        return new ModelAndView("redirect:/room/{roomUrl}");
    }

    @GetMapping("/{roomUrl}")
    public ModelAndView joinRoom(@PathVariable String roomUrl) throws RoomNotFoundException {
        if (roomService.findByUrl(roomUrl) == null) {
            throw new RoomNotFoundException();
        }

        ModelAndView modelAndView = new ModelAndView(ROOM);

        modelAndView.addObject(ROOM_URL, roomUrl);

        return modelAndView;
    }
}
