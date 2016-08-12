package ru.cases.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;

import ru.cases.command.Command;
import ru.cases.main.Main;

public class stats implements Command{
	private Main plugin;
	public stats(Main plugin){
		this.plugin=plugin;
	}
	@Override
	public List<String> getNames() {
		List<String> list = new ArrayList<>();
		list.add("stats");
		list.add("stats");
		list.add("stats");
		return list;
	}

	@Override
	public String getPermission() {
		return "cases.stats";
	}

	@Override
	public String getHelp() {
		return "/c stats/s <PlayerName> - �������� ���������� � ���-�� ������ � ������ <PlayerName>(���� �� �������, �� � ���)";
	}

	@Override
	public void Execute(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {
		if(args.length<1){
			sen.sendMessage(getHelp());
			return;
		}
		List<String> cases = plugin.getConfig().getStringList("Cases.names");
		List<String> keys = new ArrayList<>();
		if(args.length==1){
			for(int i=0;i<cases.size();i++){
				if(plugin.getConfig().getInt(sen.getName()+"."+cases.get(i), 0)>0){
					keys.add(cases.get(i)+": "+plugin.getConfig().getInt(sen.getName()+"."+cases.get(i), 0));
				}
			}
			if(keys.isEmpty()){
				sen.sendMessage("� ������ "+sen.getName()+" ��� ������");
				return;
			}
			sen.sendMessage("� ������ "+sen.getName()+" ������:");
			for(int i=0;i<keys.size();i++){
				sen.sendMessage("�� ����� "+keys.get(i));
			}
		}
		if(args.length>1){
			for(int i=0;i<cases.size();i++){
				if(plugin.getConfig().getInt(args[1]+"."+cases.get(i), 0)>0){
					keys.add(cases.get(i)+": "+plugin.getConfig().getInt(args[1]+"."+cases.get(i), 0));
				}
			}
			if(keys.isEmpty()){
				sen.sendMessage("� ������ "+args[1]+" ��� ������");
				return;
			}
			sen.sendMessage("� ������ "+args[1]+" ������:");
			for(int i=0;i<keys.size();i++){
				sen.sendMessage("�� ����� "+keys.get(i));
			}
		}
	}

}
