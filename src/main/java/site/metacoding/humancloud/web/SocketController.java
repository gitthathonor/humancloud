package site.metacoding.humancloud.web;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import site.metacoding.humancloud.domain.subscribe.Subscribe;
import site.metacoding.humancloud.web.dto.socket.MessageDto;

import java.util.List;

import static org.apache.ibatis.session.LocalCacheScope.SESSION;


@RequiredArgsConstructor
@Controller
public class SocketController {

    private final SimpMessageSendingOperations messageSendingOperations;

    @MessageMapping("/alarm")
    public void test2(MessageDto messageDto) throws Exception{
        messageSendingOperations.convertAndSend("/sub/alarm/"+messageDto.getReceiverUsername(), messageDto);
        // db에 저장 로직
    }

    @MessageMapping("/createRecruit")
    public void doCompany(MessageDto messageDto, SimpMessageHeaderAccessor messageHeaderAccessor) throws Exception{
        List<Subscribe> subscribes = (List<Subscribe>) messageHeaderAccessor.getSessionAttributes();
            for(Subscribe subscribe : subscribes){
                messageSendingOperations.convertAndSend("/sub/addRecruit/"+subscribe.getSubscribeUserId(), messageDto);
            }
        }
    }

