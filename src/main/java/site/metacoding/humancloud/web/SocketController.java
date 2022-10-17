package site.metacoding.humancloud.web;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import site.metacoding.humancloud.web.dto.socket.MessageDto;

@RequiredArgsConstructor
@Controller
public class SocketController {

    private final SimpMessageSendingOperations messageSendingOperations;

    @MessageMapping("/alarm")
    public void test2(MessageDto messageDto) throws Exception{
        System.out.println(messageDto.getAlarmType());

        messageSendingOperations.convertAndSend("/sub/alarm/"+messageDto.getReceiverUsername(), messageDto);


//        boolean checkUser = findByLoginUser(messageDto.getReceiverUsername(), messageDto.getSender()); // subscriber(이름 수정해야됨)는 글을 쓴 놈, loginuser는 지금 구독중인유저
//        if(checkUser==true){
//        } else {
//            // db에 저장
//        }
    }

    public boolean findByLoginUser(String subscriber, String loginUser){
        if(subscriber.equals(loginUser)){
            return true;
        }
        return false;
    }
}
