package com.zq.demo.service.impl.game;

import com.zq.demo.pojo.game.GamePlayer;
import com.zq.demo.dao.game.GamePlayerDao;
import com.zq.demo.service.interfaces.game.IGamePlayerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@Service
public class GamePlayerServiceImpl extends ServiceImpl<GamePlayerDao, GamePlayer> implements IGamePlayerService {

}
