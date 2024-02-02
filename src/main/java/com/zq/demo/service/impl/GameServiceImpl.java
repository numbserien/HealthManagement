package com.zq.demo.service.impl;

import com.zq.demo.pojo.Game;
import com.zq.demo.dao.GameDao;
import com.zq.demo.service.IGameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GL
 * @since 2024-01-31
 */
@Service
public class GameServiceImpl extends ServiceImpl<GameDao, Game> implements IGameService {

}
