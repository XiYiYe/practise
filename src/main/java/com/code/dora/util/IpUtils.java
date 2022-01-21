package com.code.dora.util;

import lombok.extern.slf4j.Slf4j;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @author by Dora
 * @Date 2022/1/21 17:28
 * @Description
 */
@Slf4j
public class IpUtils {

    public static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while(true) {
                NetworkInterface netInterface;
                boolean flag;
                do {
                    if (!allNetInterfaces.hasMoreElements()) {
                        return "";
                    }
                    netInterface = allNetInterfaces.nextElement();
                    flag = netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp();
                } while(flag);

                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress ip = (InetAddress)addresses.nextElement();
                    if (ip instanceof Inet4Address) {
                        return ip.getHostAddress();
                    }
                }
            }
        } catch (Exception var5) {
            log.info("IP地址获取失败", var5);
            return "";
        }
    }
}
