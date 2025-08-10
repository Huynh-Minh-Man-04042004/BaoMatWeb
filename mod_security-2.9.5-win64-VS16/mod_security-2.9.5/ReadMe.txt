01 January 2022
29 June 2022, updated for mlogc fix



                                          Apache Lounge Distribution

     mod_security-2.9.5 build with libxml2-2.9.12 lua-5.2.4 pcre-8.45 yajl-2.1.0 curl-7.80.0 for 2.4 Win64 VS16

# Original source by: Ivan Ristic <ivanr@webkreator.com>
# Original Home: https://github.com/SpiderLabs/ModSecurity/tree/v2/master
# Binary by: Steffen
# Mail: info@apachelounge.com
# Home: http://www.apachelounge.com/


# Install:

- Copy mod_security2.so to your apache/modules folder

- Copy yajl.dll to your apache/bin folder


# Add to your httpd.conf:

  LoadModule security2_module modules/mod_security2.so

- Enable the module unique_id by uncommenting:

  LoadModule unique_id_module modules/mod_unique_id.so


# Configuration: see the included documentation

# Rules and documentation : https://github.com/SpiderLabs/ModSecurity/wiki


# A very quick start:

SecRuleEngine On
SecDefaultAction "deny,phase:2,status:403"

## -- rule --


SecRule ARGS "\.\./" "t:normalizePathWin,id:50904,severity:4,t:none,t:urlDecodeUni,t:htmlEntityDecode,t:lowercase,msg:'Drive Access'" 


Call your site with: 

http://www.xxxx.com/?abc=../../ 

You should get a access denied and is logged in the Apache error.log, it is triggered by the above rule

Enjoy,

Steffen