package ru.cases.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;

import ru.cases.command.Command;
import ru.cases.main.Main;

public class key implements Command{
	private Main plugin;
	public key(Main plugin){
		this.plugin=plugin;
	}
	@Override
	public List<String> getNames() {
		List<String> list=new ArrayList<>();
		list.add("key");
		list.add("key");
		list.add("key");
		return list;
	}

	@Override
	public String getPermission() {
		return "cases.key";
	}

	@Override
	public String getHelp() {
		return "/c key add/set/del <PlayerName> <NameCase> <amount> - ��������, �������, ���������� ���-�� ������ � ������ <PlayerName> ���-��� <amount>";
	}

	@Override
	public void Execute(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {
		if(args.length<5){
			sen.sendMessage(getHelp());
			return;
		}
		if(args.length>4){
			if(args[1].equals("add")){
				int i = Integer.valueOf(args[4]);
				plugin.getConfig().set(args[2]+"."+args[3], plugin.getConfig().getInt(args[2]+"."+args[3], 0)+i);
				sen.sendMessage(args[4]+" ����(�)(��) ���� ��������� ������ "+args[2]);
			}
			if(args[1].equals("set")){
				plugin.getConfig().set(args[2]+"."+args[3], Integer.valueOf(args[4]));
				sen.sendMessage(args[4]+" ����(�)(��) ���� ����������� ������ "+args[2]);
			}
			if(args[1].equals("del")){
				int i = Integer.valueOf(args[4]);
				plugin.getConfig().set(args[2]+"."+args[3], (plugin.getConfig().getInt(args[2]+"."+args[3], 0)-i));
				sen.sendMessage(args[4]+" ����(�)(��) ���� ������� � ������ "+args[2]);
			}
			plugin.saveConfig();
			plugin.saveDefaultConfig();
		}
		
	}
	
}
