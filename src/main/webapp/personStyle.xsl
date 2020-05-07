<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <body>
                <h2>Результат запроса</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Id</th>
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>Дата рождения</th>
                        <th>Страна</th>
                    </tr>
                    <xsl:for-each select="result/persons/person">
                        <tr>
                            <td><xsl:value-of select="personId"></xsl:value-of></td>
                            <td><xsl:value-of select="firstName"></xsl:value-of></td>
                            <td><xsl:value-of select="secondName"></xsl:value-of></td>
                            <td><xsl:value-of select="birtday"></xsl:value-of></td>
                            <td><xsl:value-of select="country"></xsl:value-of></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>