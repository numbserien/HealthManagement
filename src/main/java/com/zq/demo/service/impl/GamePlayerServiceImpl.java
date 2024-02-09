package com.zq.demo.service.impl;

import com.zq.demo.pojo.GamePlayer;
import com.zq.demo.dao.GamePlayerDao;
import com.zq.demo.service.IGamePlayerService;
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
