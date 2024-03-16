package com.zq.demo.service.impl.game;

import com.zq.demo.pojo.game.Game;
import com.zq.demo.dao.game.GameDao;
import com.zq.demo.service.service.game.IGameService;
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
public class GameServiceImpl extends ServiceImpl<GameDao, Game> implements IGameService {

}
