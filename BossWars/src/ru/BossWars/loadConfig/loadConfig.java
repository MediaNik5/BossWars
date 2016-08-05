package ru.BossWars.loadConfig;

import java.io.IOException;
import org.bukkit.ChatColor;
import ru.BossWars.main.BossWars;

public class loadConfig {
	public static void loadConfigs(){
		if(BossWars.spns.exists()){
			if(BossWars.spns.equals("arenas.names")){
				BossWars.arenas = BossWars.spn.getStringList("arenas.names");
				
			}
		}
		if(BossWars.spns.exists()){
			BossWars.arenas = BossWars.spn.getStringList("arenas.names");		
		}
		if(!BossWars.lbs.exists()){
			try {
				BossWars.lbs.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			BossWars.lb.set("Locations.lobby.world", "world");
			BossWars.lb.set("Locations.lobby.x", -150);
			BossWars.lb.set("Locations.lobby.y", 64);
			BossWars.lb.set("Locations.lobby.z", 180);
			try {
				BossWars.lb.save(BossWars.lbs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BossWars.pos.worldName = BossWars.lb.getString("BossWars.lobby.world");
			BossWars.pos.x = BossWars.lb.getDouble("Locations.lobby.x");
			BossWars.pos.y = BossWars.lb.getDouble("Locations.lobby.y");
			BossWars.pos.z = BossWars.lb.getDouble("Locations.lobby.z");
		}else {
			BossWars.pos.worldName = BossWars.lb.getString("Locations.lobby.world");
			BossWars.pos.x = BossWars.lb.getDouble("Locations.lobby.x");
			BossWars.pos.y = BossWars.lb.getDouble("Locations.lobby.y");
			BossWars.pos.z = BossWars.lb.getDouble("Locations.lobby.z");
		}
		if(!(BossWars.msgs.exists()) | !(BossWars.msgs.equals("alreadyIn")) | !(BossWars.msgs.equals("enteredIn")) | !(BossWars.msgs.equals("settedLobby"))){
			try {
				BossWars.msgs.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			BossWars.msg.set("aalreadyIn", ChatColor.RED + "�� ��� � �������!!!");
			BossWars.msg.set("enteredIn", ChatColor.GREEN + "�� ����� � �������");
			BossWars.msg.set("settedLobby", ChatColor.GREEN + "����� �����������!");
			try {
				BossWars.msg.save(BossWars.msgs);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!(BossWars.cmds.exists()) | !(BossWars.cmds.equals("Commands"))){
			try {
				BossWars.cmds.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			BossWars.cmd.createSection("//����� ��� �� �������, ��� � ����� �� ���������");
			BossWars.cmd.set("Commands",ChatColor.AQUA + "/boss j/join - ���� � �������\n"
					+ "/boss sl/setlobby [world] - ��������� ����� �� ��� ����, �� ������� �� ������\n"
					+ "/boss c/create <name> - ������ �������� �����\n"
					+ "/boss pos1 - ��������� ������ �����(�������� ������ ����� ������� /boss c/create)\n"
					+ "/boss pos2 - ��������� ������ �����(�������� ������ ����� ������� /boss c/create)\n"
					+ "/boss ssp/setspawnplayers <nameCommand> - ��������� ����� ������ ������� ������� <nameCommand>(�������� ������ ����� ������ /boss pos1/2)\n"
					+ "/boss ssb/setspanwbosses <nameCommand> - ��������� ����� ������ ������ ������� <nameCommand>(�������� ������ ����� ������� /boss ssb)\n"
					+ "/boss ssm/setspawnmobs - ��������� ������ �����(�������� ������ ����� ������� /boss ssb))\n"
					+ "/boss save - ����� ��������� �����(�������� ������ ����� ������� /boss ssm)");
			try {
				BossWars.cmd.save(BossWars.cmds);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!(BossWars.lrs.exists()) | !(BossWars.lrs.equals("PlayerJoinMessage")) | !(BossWars.lrs.equals("PlayerJoinMessageon"))){
			try {
				BossWars.lrs.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			BossWars.lr.set("PlayerJoinMessageon", true);
			BossWars.lr.set("PlayerJoinMessage", ChatColor.GOLD + "����� ������ ����� ����� � ���� BossWars, ������ ������� /boss j");
			try {
				BossWars.lr.save(BossWars.lrs);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			BossWars.cmd1 = BossWars.cmd.getString("Commands");
			BossWars.lr2 = BossWars.lr.getString("PlayerJoinMessage");
			BossWars.lr1 = BossWars.lr.getBoolean("PlayerJoinMessageon");
	}
}
