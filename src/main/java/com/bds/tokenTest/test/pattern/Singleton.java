package com.bds.tokenTest.test.pattern;

public class Singleton {
	private Singleton(){}
	
	private static class SingletonHolder{
		private static Singleton s = new Singleton();
	}
	public static Singleton getInstance(){
		return SingletonHolder.s;
	}
	
	//懒汉式单例(线程安全)
//	private static Singleton s = null;
//	public static Singleton getInstance(){
//		if(s == null){
//			synchronized(Singleton.class){
//				if(s == null){
//					s = new Singleton();
//				}
//			}
//		}
//		
//		return s;
//	}
	//饿汉式单例
//	private static Singleton s = new Singleton();
//	public static Singleton getInstance(){
//		return s;
//	}
}
