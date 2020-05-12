<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns="http://foobar.com" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:x="http://foobar.com" exclude-result-prefixes="x">
    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th align="left">Id</th>
                        <th align="left">Title</th>
                        <th align="left">Issue year</th>
                        <th align="left">IMDB</th>
                        <th align="left">Length</th>
                    </tr>
                    <xsl:for-each  select="*/film" >
                        <tr>
                            <td>
                                <xsl:value-of select="filmId"/>
                            </td>
                            <td>
                                <xsl:value-of select="title"/>
                            </td>
                            <td>
                                <xsl:value-of select="issueYear"/>
                            </td>
                            <td>
                                <xsl:value-of select="imdb"/>
                            </td>
                            <td>
                                <xsl:value-of select="length"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
