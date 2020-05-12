<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns="http://foobar.com" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:x="http://foobar.com" exclude-result-prefixes="x">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Результат выборки из Базы данных</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th align="left">Id</th>
                        <th align="left">Name</th>
                        <th align="left">Family</th>
                        <th align="left">Birthday</th>
                        <th align="left">Country</th>
                    </tr>
                    <xsl:for-each  select="*/person" >
                        <tr>
                            <td>
                                <xsl:value-of select="personId"/>
                            </td>
                            <td>
                                <xsl:value-of select="firstName"/>
                            </td>
                            <td>
                                <xsl:value-of select="secondName"/>
                            </td>
                            <td>
                                <xsl:value-of select="birtday"/>
                            </td>
                            <td>
                                <xsl:value-of select="country"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
