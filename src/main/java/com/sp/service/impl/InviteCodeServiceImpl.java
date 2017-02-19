package com.sp.service.impl;

import com.blade.ioc.annotation.Inject;
import com.blade.ioc.annotation.Service;
import com.blade.jdbc.ActiveRecord;
import com.blade.jdbc.core.Take;
import com.blade.kit.DateKit;
import com.blade.kit.StringKit;
import com.sp.model.InviteCode;
import com.sp.service.InviteCodeService;
import com.sp.utils.UUID;

import java.util.List;

/**
 * Created by biezhi on 2017/2/19.
 */
@Service
public class InviteCodeServiceImpl implements InviteCodeService {

    @Inject
    private ActiveRecord activeRecord;

    @Override
    public List<InviteCode> getCodes(Take take) {
        if (null != take) {
            return activeRecord.list(take);
        }
        return null;
    }

    @Override
    public void saveCodes(Integer user_id, int num) {
        for(int i=0; i<num; i++){
            String code = UUID.UU32();
            InviteCode inviteCode = new InviteCode();
            inviteCode.setCode(code);
            inviteCode.setUser_id(user_id);
            inviteCode.setCreated_at(DateKit.getCurrentUnixTime());
            inviteCode.setUpdated_at(DateKit.getCurrentUnixTime());
            activeRecord.insert(inviteCode);
        }
    }

    @Override
    public InviteCode byCode(String code) {
        if(StringKit.isNotBlank(code)){
            InviteCode inviteCode = new InviteCode();
            inviteCode.setCode(code);
            return activeRecord.one(inviteCode);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if(null != id){
            activeRecord.delete(InviteCode.class, id);
        }
    }
}
